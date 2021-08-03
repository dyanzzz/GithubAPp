package com.kotlin.githubapps.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.githubapps.data.model.Reminder
import com.kotlin.githubapps.databinding.ActivitySettingsBinding
import com.kotlin.githubapps.preference.ReminderPreference
import com.kotlin.githubapps.receiver.AlarmReceiver

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var reminder: Reminder
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reminderPreference = ReminderPreference(this)

        // set kondisi untuk checkbox, ketika -- reminderPreference.getReminder().isReminded -- bernilai true/false
        binding.switch1.isChecked = reminderPreference.getReminder().isReminded
        /*if (reminderPreference.getReminder().isReminded) {
            binding.switch1.isChecked = true
        } else {
            binding.switch1.isChecked = false
        }*/

        alarmReceiver = AlarmReceiver()

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                saveReminder(true)
                alarmReceiver.setRepeatingAlarm(this, "Repeating Alarm", "15:57", "Github Reminder")
            } else {
                saveReminder(true)
                alarmReceiver.cancelAlarm(this)
            }
        }
    }

    private fun saveReminder(state: Boolean) {
        val reminderPreference = ReminderPreference(this)
        reminder = Reminder()

        reminder.isReminded = state
        reminderPreference.setReminder(reminder)
    }
}