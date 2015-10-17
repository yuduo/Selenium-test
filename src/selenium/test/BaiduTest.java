package selenium.test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver ;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Proxy.ProxyType;

import com.gargoylesoftware.htmlunit.javascript.host.Window;

import util.TxtWriter;
 
public class BaiduTest {
 
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO Auto-generated method stub
    	//设置访问ChromeDriver的路径  
    	//System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"); 
        
        org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy(); 
        proxy.setHttpProxy("127.0.0.1:8580")
        	.setSslProxy("127.0.0.1:8580")
        	.setFtpProxy("127.0.0.1:8580"); 
      
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);
        
       // WebDriver driver = new ChromeDriver(cap);
        //WebDriver driver = new InternetExplorerDriver();
        WebDriver driver = new FirefoxDriver();
        // 隐性的等待,设置10秒  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
      
        setScroll(driver, 10000);
 
        /***************************************************************/
        
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("Hello Webdriver!");
        driver.findElement(By.id("su")).click();
        System.out.println(driver.getTitle());

        driver.findElement(By.linkText("图片")).click();
        System.out.println(driver.getTitle());
        
        /****************************登陆126邮箱***********************************/
        
        /*driver.get("http://www.126.com/");
        driver.findElement(By.id("idInput")).sendKeys("yifang200571");
        driver.findElement(By.id("pwdInput")).sendKeys("by14285700");
        driver.findElement(By.id("loginBtn")).click();
        driver.findElement(By.linkText("已发送")).click();
        System.out.println(driver.getTitle());*/
        
        /***************************************************************/
        
        /*****************************登陆新浪微博**********************************/
        
        /*driver.get("http://weibo.com/");
        driver.findElement(By.name("username")).sendKeys("luoyuanfeifei@163.com");
        driver.findElement(By.name("password")).sendKeys("300201");
        driver.findElement(By.xpath("//*[@id=\"pl_login_form\"]/div[4]/div[6]/div[1]/a")).click();
        System.out.println(driver.getTitle());*/
        
        /***************************************************************/
        
        /*****************************登陆Google+**********************************/
        // 登陆Google+
        /*
        driver.get("https://accounts.google.com/ServiceLoginAuth");
        Thread.sleep(1000);
        driver.findElement(By.name("Email")).sendKeys("yuqingee01@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("Passwd")).sendKeys("iee123456");
        Thread.sleep(1000);
        driver.findElement(By.name("signIn")).click();
        
        // 查看圈子
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
        System.out.println(driver.getTitle());*/
        
        // 搜索关键词
      /*  driver.get("https://plus.google.com");
        driver.findElement(By.id("gbqfq")).sendKeys("姚明");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"gbqfb\"]/span")).click();
        //String html = driver.getPageSource();  
        //打印网页源码  
        //System.out.println(html); 
       
        // 通过 id 找到 input 的 DOM
        WebElement element = driver.findElement(By.id("gbqfq"));
		
        // 输入关键字
        element.sendKeys("姚明");
		
        // 提交input所在的 form
        element.submit();
 
        // 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒
        (new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().endsWith("姚明");
            }

        });
        
        StringBuilder sb = new StringBuilder(); 
        WebElement webElement = driver.findElement(By.xpath("//div[@class='pga']" ));
        sb.append(webElement.getAttribute("outerHTML"));
       
        TxtWriter.saveToFile(sb.toString(), new File("D:/html1.dat"), "UTF-8");
        
        //sb = new StringBuilder();
        
        int num = 5;
        while(num-- > 0) {
        	((JavascriptExecutor)driver).executeScript("scrollTo(0,1000000)");
            //  driver.findElement(By.id("shell")).sendKeys(Keys.END);
            Thread.sleep(5000L);
            webElement = driver.findElement(By.xpath("//div[@class='pga']" ));
            sb.append(webElement.getAttribute("outerHTML"));
        }

       
        WebElement target = driver.findElement(By.xpath("//*[@id=\"contentPane\"]/div/div[2]/div/div/div/div/script[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);
        
        webElement = driver.findElement(By.xpath("/html"));
        
        sb.append(webElement.getAttribute("outerHTML"));*/
        
        //System.out.println(webElement.getAttribute("outerHTML"));
        //TxtWriter.saveToFile(sb.toString(), new File("D:/html2.dat"), "UTF-8");
        
        
        /***************************************************************/

        // 关闭进程
        //driver.close();
        // 关闭浏览器
        //driver.quit();     	 
    }
    
    
    // 将滚动条滚到适合的文章
    public static void setScroll(WebDriver driver, int height) {
    	
    	try {
    		String setscroll = "document.body.scrollTop=" + height;
    		
    		JavascriptExecutor jse = (JavascriptExecutor) driver;
        	jse.executeScript(setscroll);
        	
    	} catch (Exception e) {
    		System.out.println("Fail to set the scroll.");	
    	}
    }
 
}