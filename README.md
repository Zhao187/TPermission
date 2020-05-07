<h1 align="center">Welcome to TPermission 👋</h1>

🏠 Homepage

✨ Demo

Install

    Step 1. Add the JitPack repository to your build file
    	allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
    	}
    Step 2. Add the dependency
    dependencies {
    	implementation 'com.github.Zhao187:TPermission:Tag'
    }

Usage

      TPermission.request(
                        this,
                        Manifest.permission.CALL_PHONE) { allGranted, deniedList ->
                    if (allGranted) {
                        call()
                    } else {
                        Toast.makeText(this, "You  Denied $deniedList", Toast.LENGTH_SHORT).show()
                    }
                }



Author


👤 赵宏图

- 个人博客: http://39.106.130.249:8088/blog/
- GitHub: Steven.zhao
- 码云:https://gitee.com/zhao187

🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check issues page. <%= contributingUrl ? You can also take a look at the [contributing guide](${contributingUrl}). : '' %>
<% } -%>

Show your support

Give a ⭐️ if this project helped you!



📝 License

Steven.zhao && Zhao187
Copyright © 2020 Zhao187.<br />


