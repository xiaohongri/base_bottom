package com.example.base_bottom
/*
    包括主页等的框架
 */
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : BaseActivity_login(), RadioGroup.OnCheckedChangeListener {
    //初始化Fragment集合

    //1、首先声明一个数组permissions，将需要的权限都放在里面
    val permissions = arrayOf(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE)
    val mPermissionList = ArrayList<String>()
    val mRequestCode = 0x1//权限请求码



    var fragmentList = mutableListOf<Fragment>()
    //声明五个Fragment
    private lateinit var articleFragment: ArticleFragment
    private lateinit var beautyFragment: fragment_merchant
    private lateinit var biscuitsFragment: BiscuitsFragment
    private lateinit var personalFragment: PersonalFragment
    private lateinit var videoFragment: fragment_adminmngm
    //用作显示隐藏Fragment所用
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPermission()
        setContentView(layoutId())
        initView()
        initData()
    }


    //初始化布局
    fun layoutId(): Int {
        return R.layout.activity_main
    }


    fun initView() {
        //设置RadioGroup的监听
        rg.setOnCheckedChangeListener(this)
        //更改底部图标大小

        //初始化Fragment
        initFragment()
        //设置默认Fragment
        initSetNormalFragment()
    }

    fun initPermission() {
        mPermissionList.clear()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                mPermissionList.add(permission)
            }
        }
        if (!mPermissionList.isEmpty()) {
            // 后续操作...
            ActivityCompat.requestPermissions(this@MainActivity, permissions, mRequestCode)

        } else {
            Toast.makeText(this@MainActivity,"全部授予！",Toast.LENGTH_SHORT).show()


        }
    }


//检查底部按钮是否被按下
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val fm = supportFragmentManager
        when (checkedId) {
            R.id.rb_article ->
                showFragment(fragmentList[0], fm)
            R.id.rb_beauty ->
                showFragment(fragmentList[1], fm)
            R.id.rb_biscuits ->{
                showFragment(fragmentList[2], fm)
            }
            R.id.rb_video ->
                showFragment(fragmentList[3], fm)
            R.id.rb_personal ->
                showFragment(fragmentList[4], fm)
        }
    }

    //默认加载第一个fragment
    fun initSetNormalFragment() {
        val fm = supportFragmentManager
        showFragment(fragmentList[0], fm)

    }

    //将fragment添加进集合
    fun initFragment() {
        currentFragment = Fragment()
        articleFragment = ArticleFragment.newInstance()
        beautyFragment = fragment_merchant.newInstance()
        biscuitsFragment = BiscuitsFragment.newInstance()
        personalFragment = PersonalFragment.newInstance()
        videoFragment = fragment_adminmngm.newInstance()


        fragmentList.add(articleFragment)
        fragmentList.add(beautyFragment)
        fragmentList.add(biscuitsFragment)
        fragmentList.add(videoFragment)
        fragmentList.add(personalFragment)
    }

    //因为布局中radioButton的图标太大，无法控制，所用在代码中去控制图标的大小


    //设置图标的大小


    //加载数据使用，暂未用到
    fun initData() {
    }


    //用来控制Fragment的显示隐藏
    fun showFragment(fragment: Fragment, fm: FragmentManager) {
        //判断当前显示的是否是需要展示的Framgnet，可以省略不必要步骤
        var account = intent.getStringExtra("account")
        if (currentFragment != fragment) {
            //隐藏当前Fragment
            val transaction = fm.beginTransaction()
            transaction.hide(currentFragment)
            //将fragment替换成目前传入的fragment
            currentFragment = fragment
            //判断当前fragment是否添加进事务中
            if (!fragment.isAdded) {
                //添加显示
                val bundle = Bundle()
                bundle.putString("account", account)
                fragment.setArguments(bundle)
                transaction.add(R.id.fl_layout, fragment).show(fragment).commit()
            } else {
                //显示
                transaction.show(fragment).commit()
            }
        }
    }

    //重写
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            0x1 -> for (i in 0 until grantResults.size) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) Toast.makeText(
                    this,
                    "您有未授予的权限，可能影响使用",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        }// 授权结束后的后续操作



}

