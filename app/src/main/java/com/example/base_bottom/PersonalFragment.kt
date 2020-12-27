package com.example.base_bottom
/*
    个人中心页面
 */
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.net.Uri
import android.util.Log
import com.example.base_bottom.channge_passwd.Chaneg_Passwd
import kotlinx.android.synthetic.main.fragment_dashboard.*

import java.io.File


class PersonalFragment : Fragment(){


    val takePhoto = 1
    lateinit var imageUri: Uri
    lateinit var outputImage: File

    val fromAlbum = 2



    companion object {
        fun newInstance() : PersonalFragment {//调用这个函数，创建新的fragment

            val fragment = PersonalFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }


    //lateinit var timeChangeReceiver: PersonalFragment.TimeChangeReceiver
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG,"66666666666")

        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //var account = intent.getStringExtra("account")
        val bundle = arguments
        var mess: String? = null
        if (bundle != null) {
            Log.d("BiscuitsFragment",bundle.getString("account"))
            mess = bundle.getString("account")
        }

        version.setOnClickListener{
            AlertDialog.Builder(this.context).apply {
                setTitle("版本")
                setMessage("北斗物流1.0")
                setPositiveButton("确认") { dialog, which -> }
                show()
            }
        }

        change_pawwsd.setOnClickListener {
            val intent = Intent(this.context, Chaneg_Passwd::class.java)
            intent.putExtra("account",mess)
            startActivity(intent)
        }

        about_us.setOnClickListener{
            AlertDialog.Builder(this.context).apply {
                setTitle("关于我们")
                setMessage("北斗开发员")
                setPositiveButton("确认"){dialog, which ->  }
                show()
            }
        }

        about_us.setOnClickListener{
            AlertDialog.Builder(this.context).apply {
                setTitle("关于我们")
                setMessage("北斗开发员")
                setPositiveButton("确认"){dialog, which ->  }
                show()
            }
        }

        imageView.setOnClickListener{
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)

            intent.type = "image/*"
            startActivityForResult(intent,fromAlbum)
        }

        log_out.setOnClickListener{
            val intent = Intent("com.example.broadcastbestpractice.FORCE_OFFLINE")
            getActivity()?.sendBroadcast(intent)
        }

    }





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){


            fromAlbum->{
                if (resultCode == Activity.RESULT_OK && data != null){
                    data.data?.let { uri ->
                        val bitmap = getBitmapFromUri(uri)
                        imageView.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }



    private fun rotateIfRequired(bitmap: Bitmap): Bitmap {
        val exif = ExifInterface(outputImage.path)
        val orientation = exif.getAttributeInt(
            ExifInterface.TAG_ORIENTATION,
            ExifInterface.ORIENTATION_NORMAL)
        return when(orientation){
            ExifInterface.ORIENTATION_ROTATE_90->rotateBitmap(bitmap,90)
            ExifInterface.ORIENTATION_ROTATE_180->rotateBitmap(bitmap,180)
            ExifInterface.ORIENTATION_ROTATE_270->rotateBitmap(bitmap,270)
            else->bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap, degree:Int): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotatedBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.width,bitmap.height,matrix,true)
        bitmap.recycle()
        return rotatedBitmap
    }

    private fun getBitmapFromUri(uri: Uri) = getActivity()?.contentResolver?.openFileDescriptor(uri,"r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }



}






