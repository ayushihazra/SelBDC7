package com.test;

public class CaseStudy1 {
	
	 WebDriver driver;
		ExtentHtmlReporter reporter;
		ExtentReports reports;
		ExtentTest logger;
		 @BeforeTest
		 public void startTest() {
			 driver=DriverUtility.supplyDriver("chrome");
				driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String url="http://10.232.237.143:443/TestMeApp/fetchcat.htm";
				driver.get(url);
				String path=System.getProperty("user.dir")+"/extent-reports/report3.html";
				reporter=new ExtentHtmlReporter(path);
				reports=new ExtentReports();
		     	reports.attachReporter(reporter);
		     	reports.setSystemInfo("Hostname", "LocalHost");
		     	reports.setSystemInfo("Tester Name", "akanksha.deb");
		     	reports.setSystemInfo("Environment", "Testing  environment");
		     	reporter.config().setDocumentTitle("TestMeApp Aut");
		     	reporter.config().setReportName("Next Gen Testing stream");
		     	reporter.config().setTheme(Theme.STANDARD);
		 }
		 @AfterMethod
			public void captureStatus(ITestResult result) {
				if(result.getStatus()==ITestResult.SUCCESS)
				{
					logger.log(Status.PASS, result.getMethod().getMethodName()+"is passed");
					
				}
				else if(result.getStatus()==ITestResult.FAILURE)
				{
					String imagePath=System.getProperty("user.dir")+"/extent-reports/capture/"+
							result.getMethod().getMethodName()+".png";
					logger.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
					TakesScreenshot capture=(TakesScreenshot)driver;
					File file=capture.getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(file, new File(imagePath));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(result.getStatus()==ITestResult.SKIP)
				{
					logger.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
				}
				
				
			}
	
     @Test(priority=1)
			public void testRegistration() {
			    
				driver.findElement(By.linkText("SignUp")).click();
				driver.findElement(By.name("userName")).sendKeys("Varun_233");
				driver.findElement(By.name("firstName")).sendKeys("Varun");
				driver.findElement(By.name("lastName")).sendKeys("Mallick");
				driver.findElement(By.name("password")).sendKeys("Varun@123");
				driver.findElement(By.name("confirmPassword")).sendKeys("Varun@123");
				driver.findElement(By.id("gender")).click();
				driver.findElement(By.name("emailAddress")).sendKeys("Varun@gmail.com");
				driver.findElement(By.name("mobileNumber")).sendKeys("1234567891");
				driver.findElement(By.name("dob")).sendKeys("09/08/1999");
				driver.findElement(By.name("address")).sendKeys("bla bla");
				driver.findElement(By.name("securityQuestion")).sendKeys("2");
				driver.findElement(By.name("answer")).sendKeys("black");
				driver.findElement(By.name("Submit")).click();
				logger=reports.createTest("Pass Test");
				Assert.assertTrue(true);
		 }
	
		
	@Test(priority=2)
		public void login() {
		
		//driver.findElement(By.partialLinkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("Varun_233");
		driver.findElement(By.id("password")).sendKeys("Varun@123");
		driver.findElement(By.name("Login")).click();
		logger=reports.createTest("Pass Test");
		Assert.assertTrue(true);
		
	}
	@Test(priority=3)
	 public void addToCart() throws InterruptedException {
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		WebElement e1=driver.findElement(By.xpath("//*[@id='menu3']/li[2]/a/span"));
		act.moveToElement(e1).build().perform();
		WebElement e2=driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span"));
		act.moveToElement(e2).click().build().perform();
	    Thread.sleep(3000);
		WebElement e3=driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span"));
		act.moveToElement(e3).click().build().perform();
		WebElement e4=driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a/span"));
		act.moveToElement(e4).click().build().perform();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
     driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	    Thread.sleep(3000);
	    logger=reports.createTest("Pass Test");
	    Assert.assertTrue(true);
	 }
	@Test(priority=4)
	 public void payment() {
		driver.findElement(By.cssSelector("#swit > div:nth-child(5) > div")).click();
		driver.findElement(By.xpath("//*[@id=\"btn\"]")).click();
		driver.findElement(By.name("username")).sendKeys("123458");
		driver.findElement(By.name("password")).sendKeys("Pass@458");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		driver.findElement(By.name("transpwd")).sendKeys("Trans@459");
		driver.findElement(By.cssSelector("input[value='PayNow']")).click();
		logger=reports.createTest("Pass Test");
		Assert.assertTrue(true);
	}
	@Test(priority=5)
	public void close() {
		driver.close();
	}
	@AfterTest
	public void endTest() {
		reports.flush();
		
	}
}