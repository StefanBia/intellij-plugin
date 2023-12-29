package com.example.demo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import java.awt.*
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel


class HelloWorldAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val frame = JFrame("Hello World Frame")
        val label = JLabel("Hello World!")
        val closeButton = JButton("OK")

        frame.layout = BorderLayout()

        val labelPanel = JPanel(GridBagLayout())
        val labelConstraints = GridBagConstraints()
        labelPanel.add(label, labelConstraints)

        val buttonPanel = JPanel(FlowLayout(FlowLayout.CENTER))
        buttonPanel.add(closeButton)

        frame.add(labelPanel, BorderLayout.CENTER)
        frame.add(buttonPanel, BorderLayout.SOUTH)


        // Set background color of the frame
        frame.contentPane.background = Color.decode("#DDC7A0")

        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setSize(300, 200)
        frame.setLocationRelativeTo(null) // Open in the middle of the screen
        frame.isVisible = true

        closeButton.addActionListener { frame.dispose() }
    }

    internal class JButtonPanel : JPanel() {
        init {
            layout = FlowLayout(FlowLayout.CENTER)
        }
    }
}
