package com.android.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_view_pager2.setOnClickListener(this)
        bt_recycler_linear.setOnClickListener(this)
        bt_recycler_grid.setOnClickListener(this)
        bt_grid_view.setOnClickListener(this)
        bt_draw_test.setOnClickListener(this)
        bt_crime.setOnClickListener(this)
        bt_room.setOnClickListener(this)
        bt_camera.setOnClickListener(this)
        bt_shape.setOnClickListener(this)
        bt_fragment.setOnClickListener(this)
        bt_dialog.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.bt_view_pager2 -> ViewPager2Activity.actionStart(this)
            R.id.bt_recycler_linear -> RecyclerLinearActivity.actionStart(this)
            R.id.bt_recycler_grid -> RecyclerGridActivity.actionStart(this)
            R.id.bt_grid_view -> GridViewActivity.actionStart(this)
            R.id.bt_draw_test -> SurfaceViewActivity.actionStart(this)
            R.id.bt_crime -> CrimeActivity.actionStart(this)
            R.id.bt_room -> RoomTestActivity.actionStart(this)
            R.id.bt_camera -> CameraAlbumActivity.actionStart(this)
            R.id.bt_shape -> ShapeTestActivity.actionStart(this)
            R.id.bt_fragment -> StartFragmentActivity.actionStart(this)
            R.id.bt_dialog -> DialogActivity.actionStart(this)
        }
    }
}