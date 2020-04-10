package yml.minla.jnitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import yml.minla.jnitest.jnipack.JniTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jniTest = JniTest()
        tv_show_version.text = jniTest.jniLibraryName
    }
}
