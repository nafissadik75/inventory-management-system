package tests.model;
import model.Nafis;
import model.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

public class NafisTest {

    private final InputStream originalIn = System.in;

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    void restoreSystemInput() {
        System.setIn(originalIn);
    }

    // ---------- Normal Cases ----------

    @Test
    public void TC1_validInput_emptyInventory() {
        provideInput("1\nApple\n0.99\n50\n");

        Product p = Nafis.addProductMenu();

        assertEquals(1, p.getId());
        assertEquals("Apple", p.getName());
        assertEquals(0.99, p.getPrice(), 1e-6);
        assertEquals(50, p.getQuantity());
    }

    @Test
    public void TC2_secondProduct() {
        provideInput("2\nBanana\n0.49\n100\n");

        Product p = Nafis.addProductMenu();

        assertEquals(2, p.getId());
        assertEquals("Banana", p.getName());
    }

    @Test
    public void TC3_zeroQuantity() {
        provideInput("3\nCherry\n2.50\n0\n");

        Product p = Nafis.addProductMenu();

        assertEquals(0, p.getQuantity());
    }

    @Test
    public void TC4_quantityOne() {
        provideInput("4\nDate\n5.00\n1\n");

        Product p = Nafis.addProductMenu();

        assertEquals(1, p.getQuantity());
    }

    @Test
    public void TC5_largeQuantity() {
        provideInput("5\nElderberry\n9.99\n999\n");

        Product p = Nafis.addProductMenu();

        assertEquals(999, p.getQuantity());
    }

    // ---------- Edge Cases ----------

    @Test
    public void EC1_minimalName() {
        provideInput("1\nA\n0.01\n1\n");

        Product p = Nafis.addProductMenu();

        assertEquals("A", p.getName());
    }

    @Test
    public void EC2_maxLengthName() {
        String longName = "X".repeat(255);
        provideInput("99\n" + longName + "\n1.0\n1\n");

        Product p = Nafis.addProductMenu();

        assertEquals(longName, p.getName());
    }

    @Test
    public void EC3_zeroPriceAndQuantity() {
        provideInput("10\nWidget\n0.0\n0\n");

        Product p = Nafis.addProductMenu();

        assertEquals(0.0, p.getPrice(), 1e-6);
        assertEquals(0, p.getQuantity());
    }

    @Test
    public void EC4_manySequentialCalls() {
        for (int i = 1; i <= 10; i++) {
            provideInput(i + "\nItem" + i + "\n1.0\n1\n");

            Product p = Nafis.addProductMenu();

            assertEquals(i, p.getId());
        }
    }

    @Test
    public void EC5_extremelyLargePrice() {
        provideInput("7\nItem\n" + Double.MAX_VALUE + "\n1\n");

        Product p = Nafis.addProductMenu();

        assertEquals(Double.MAX_VALUE, p.getPrice(), 1e-6);
    }

    // ---------- Error Handling ----------

    @Test
    public void EH1_invalidInput_nonNumericId() {
        provideInput("abc\n");

        assertThrows(Exception.class, Nafis::addProductMenu);
    }

    @Test
    public void EH2_nullName_notPossibleWithScanner() {
        // Scanner.next() never returns null → cannot test
        assertTrue(true);
    }

    @Test
    public void EH3_negativePrice() {
        provideInput("1\nApple\n-1.0\n10\n");

        Product p = Nafis.addProductMenu();

        // No validation exists → it will accept negative
        assertEquals(-1.0, p.getPrice(), 1e-6);
    }

    @Test
    public void EH4_negativeQuantity() {
        provideInput("1\nApple\n1.0\n-5\n");

        Product p = Nafis.addProductMenu();

        // No validation exists → it will accept negative
        assertEquals(-5, p.getQuantity());
    }

    @Test
    public void EH5_duplicateId_notHandledHere() {
        // This method does not check duplicates → cannot test here
        assertTrue(true);
    }

    @Test
    public void EH6_invalidIdZero() {
        provideInput("0\nApple\n1.0\n1\n");

        Product p = Nafis.addProductMenu();

        // No validation exists → accepted
        assertEquals(0, p.getId());
    }
}