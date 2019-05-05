# Intent
通过自定义WebView验证隐式Intent的使用
#### 一、隐式Intent的设置
```
public class MainActivity extends AppCompatActivity {

    Button bt;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentlayout);
        bt=(Button)findViewById(R.id.btn);
        et=(EditText)findViewById(R.id.et);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url="http://"+et.getText().toString();
                intent.putExtra("url",url);
                Intent choose=Intent.createChooser(intent,"选择一个浏览器");
                startActivity(intent);
            }
        });
    }
}
```
#### 二、自定义WebView
```
    private WebView webView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.webview);

        webView=(WebView)findViewById(R.id.webview);

        Bundle bundle=getIntent().getExtras();

        String url=bundle.getString("url");

        Log.i("dd",url);

        //String url="https://www.baidu.com";



        WebSettings settings=webView.getSettings();

        settings.setJavaScriptEnabled(true);

        settings.setSupportZoom(true);

        settings.setDomStorageEnabled(true);

        settings.setJavaScriptCanOpenWindowsAutomatically(true);

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient(){

            @Override

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                //返回值是true的时候控制网页在WebView中去打开，如果为false调用系统浏览器或第三方浏览器去打开

                webView.loadUrl(url);

                return true;

            }

        });
```
#### 三、界面
1、主界面  
![https://github.com/fdd54/Intent/blob/master/images/mianview.jpg]  
2、选择打开网址的应用界面  
![https://github.com/fdd54/Intent/blob/master/images/choose.jpg]  
3、自定义webView  
![https://github.com/fdd54/Intent/blob/master/images/mywebview.jpg]   
