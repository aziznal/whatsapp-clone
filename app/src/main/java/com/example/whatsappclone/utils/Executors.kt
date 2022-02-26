package com.example.whatsappclone.utils

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

/**
 * Method to run code on a background thread. Used for io/database operations.
 * */
fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}