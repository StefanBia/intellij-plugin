package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.ui.JBColor
import java.awt.*
import java.util.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel


class HelloWorldAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val frame = JFrame("")
        val label = JLabel("Hello World!")
        val closeButton = JButton("OK")
        val randColorButton = JButton("Rand Color")

        frame.layout = BorderLayout()
        label.setForeground(getRandomColor())
        closeButton.setBorderPainted(false);
        randColorButton.setBorderPainted(false)
//        closeButton.setFocusPainted(false);
//        closeButton.setContentAreaFilled(false);

        label.setFont(Font("Garamond", Font.BOLD, 30))

        val labelPanel = JPanel(GridBagLayout())
        val labelConstraints = GridBagConstraints()
        labelPanel.add(label, labelConstraints)

        val buttonPanel = JPanel(FlowLayout(FlowLayout.CENTER))
        buttonPanel.add(closeButton)
        buttonPanel.add(randColorButton)

        labelPanel.setBackground(Color.decode("#DDC7A0"));
        buttonPanel.setBackground(Color.decode("#DDC7A0"));

        frame.add(labelPanel, BorderLayout.CENTER)
        frame.add(buttonPanel, BorderLayout.SOUTH)


        // Set background color of the frame
        frame.contentPane.background = JBColor.BLUE

        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(400, 300)
        frame.setLocationRelativeTo(null) // Open in the middle of the screen
        frame.isVisible = true

        closeButton.addActionListener { frame.dispose() }
        randColorButton.addActionListener{
            label.setForeground(getRandomColor())
        }
    }

    private fun getRandomColor(): Color {
        val random = Random()
        return Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }
}
