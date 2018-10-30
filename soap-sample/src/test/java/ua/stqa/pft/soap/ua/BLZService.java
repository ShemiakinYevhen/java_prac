package ua.stqa.pft.soap.ua;

import com.thomas_bayer.blz.DetailsType;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BLZService {

    @Test
    public void testMySoapAPI() {
        DetailsType bank = new com.thomas_bayer.blz.BLZService().getBLZServiceSOAP12PortHttp().getBank("87069077");
        System.out.println(bank.getBezeichnung());
        System.out.println(bank.getBic());
        System.out.println(bank.getOrt());
        System.out.println(bank.getPlz());
        //assertEquals(bank.getBezeichnung(), "");
    }
}
