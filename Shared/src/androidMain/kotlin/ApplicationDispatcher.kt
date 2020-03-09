package com.anggitprayogo.kotlinmultiplatformproject

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineContext
    get() = Dispatchers.Default //To change initializer of created properties use File | Settings | File Templates.