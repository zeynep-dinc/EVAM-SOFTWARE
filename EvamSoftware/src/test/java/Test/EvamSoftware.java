package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ZeynepDinc.EvamSoftware.Base;

public class EvamSoftware extends Base {

	@Test
	public void test() {
		try {
			// Ön Ayarlar. Bu kısımda ben kendi bilgisayarımda google chrome'un 77. sürümünü
			// kullandığım için onda çalıştım. İsterseniz ek olarak uygulamada 78 ve 75.
			// sürümlerde bulunmaktadır.
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver77.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://evam.com");
			beklemeSuresi(5000);
			// Sayfa Açıldı
			Actions action = new Actions(driver);
			xPathClick(getContactMenu());
			beklemeSuresi(5000);
			// Contact butonuna tıklanıldı
			// Formun sırasıyla ad ve soyad, telefon, mail ve şirket kısımları doldurulur.
			// En sona adres kısmı bırakılır.
			xPathSendKey(getNameTxt(), "Zeynep DİNÇ");
			beklemeSuresi(3000);
			xPathSendKey(getNumberTxt(), "05546797494");
			beklemeSuresi(3000);
			xPathSendKey(getEmailTxt(), "zeynepdinc.23@gmail.com");
			beklemeSuresi(3000);
			xPathSendKey(getCompanyTxt(), "Yok");
			beklemeSuresi(3000);
			// Adres kısmında herbir xpath adresi sırasıyla dizine yerleştirilir, divlerler
			// ilgili İstanbulda bir sorun olduğu için
			// i'nin 0'a eşit olması durumunu, i%2'nin 1 durumunu ve i'nin 2ye eşit olması
			// durumlarını ele aldım. Yani aslında i%2==0
			// durumunu ayrıştırdım. Tab tuşuna basılarak boşluk bırakılması istenmiş
			// okunmayı kolaylaştırmak adına fakat tab tuşu boşluk bırakmıyor. Normal boşluk
			// bırakmakta yazdırdığımda okunma açısından görsel olarak sorun oluyordu.Onun
			// için insiyatif alarak çift enter kullandım.
			String copyText[] = new String[4];
			for (int i = 0; i < 4; i++) {
				// p xpath
				// *[@id="page-14"]/div[10]/div[1]/div/div[1]/div/div[2]/p[2]->Amerika
				// *[@id="page-14"]/div[10]/div[1]/div/div[2]/div/div[2]/p[2]->Amsterdam
				// *[@id="page-14"]/div[10]/div[1]/div/div[1]/div/div[3]/div/div/div[2]/p[2]->İstanbul
				// *[@id="page-14"]/div[10]/div[1]/div/div[2]/div/div[4]/p[2]->Moskova

				if (i == 0) {
					copyText[i] = xPath("//*[@id=\"page-14\"]/div[10]/div[1]/div/div[1]/div/div[2]/p[2]").getText();
				} else if (i % 2 == 1) {
					action.sendKeys(Keys.PAGE_DOWN).perform();
					beklemeSuresi(5000);
					copyText[i] = xPath("//*[@id=\"page-14\"]/div[10]/div[1]/div/div[2]/div/div[" + (i + 1) + "]/p[2]")
							.getText();
					action.sendKeys(Keys.PAGE_UP).perform();
					beklemeSuresi(5000);
				} else {
					copyText[i] = xPath("//*[@id=\"page-14\"]/div[10]/div[1]/div/div[1]/div/div[3]/div/div/div[2]/p[2]")
							.getText();
				}
				beklemeSuresi(5000);
			}
			for (int i = 0; i < 4; i++) {
				xPathSendKey(getAdressBarTxt(), copyText[i] + Keys.ENTER + Keys.ENTER);
			}
			beklemeSuresi(5000);
			xPathClick(getSendButton());
		} catch (Exception hata) {
			hata.printStackTrace();
		}
	}

}
