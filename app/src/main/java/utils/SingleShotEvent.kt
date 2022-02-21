import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.atomic.AtomicBoolean

class SingleShotEvent<T : Any?>(private val value: T? = null) : MutableLiveData<T>(value) {
    var handled = AtomicBoolean(false)

    override fun getValue(): T? {
        return if (!handled.get()) {
            handled.set(true)
            value
        } else {
            null
        }
    }

    @MainThread
    override fun setValue(value: T) {
        handled.set(false)
        super.setValue(value)
    }
}