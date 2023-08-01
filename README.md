# API Demos 

# Projede kullanılan araçlar ve kütüphaneler
![626cf9e18a940e6b0d9ddb73_images](https://user-images.githubusercontent.com/49526501/175019138-857b6b37-80ac-4c84-9905-9110138fe71b.png)

Appium,selenium,cucumber, emulator için android studio.  

Projede APIDemos.apk bulunmaktadır, fazladan yüklemeye gerek yoktur.  

Projede ElementHelper util olarak oluşturulup eylemler bu util arayıcılığı ile çağırılmaktadır.

# Test Koşması

Testlerin koşması için appium server açık olmalıdır.   
Testler "resources/testSuites/mobile.xml" dosyasını çalıştırarak tetiklenir.
Ayrıca ayrı ayrı feature dosyalarından ve test runner üzerinden de çalıştırılabilir.

![appium](https://github.com/candan9/api-demos/assets/49526501/f8208477-cf5c-4776-b1b9-ee98e3491bb1)


Eğer resimdeki cihazın kurumulunu yaparsanız, Emulator, mobile.xml dosyası çalıştırıldığında otomatik olarak açılacaktır.

# Raporlama

Projede Cucumber ve spark report bulunmaktadır.

Raporlar, /Reports/CucumberReport ve /Report/SparkReport klasörleri altında html olarak oluşmaktadır.
