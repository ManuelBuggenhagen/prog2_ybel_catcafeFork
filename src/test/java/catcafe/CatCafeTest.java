package catcafe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CatCafeTest {
    /**
     * testing method "getCatByName" with null parameter -> expecting a null return
     */
    @Test
    public void testGetCatByNameForNullPara() {
        CatCafe cafe = new CatCafe();
        assertNull(cafe.getCatByName(null));
    }

    /**
     * testing method "getCatByName" with valid parameter -> expecting a not null return
     */
    @Test
    public void testGetCatByNameWithValidPara() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("TestA", 2));
        assertNotNull(cafe.getCatByName("TestA"));
    }

    /**
     * testing method "getCatByName" with valid parameter -> expecting a null return (no result found)
     */
    @Test
    public void testGetCatByNameWithIncorrectPara() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("TestA", 2));
        assertNull(cafe.getCatByName("TestB"));
    }


    /**
     * testing method "getCatByWeight" with invalid parameter -> expecting a null return
     */
    @Test
    public void testGetCatByWeightIncorrectPara2() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("TestA", 2));
        assertNull(cafe.getCatByWeight(3, 2));
    }

    /**
     * testing method "getCatByWeight" with invalid parameter -> expecting a null return
     */
    @Test
    public void testGetCatByWeightIncorrectPara() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("TestA", 2));
        assertNull(cafe.getCatByWeight(-1, 3));
    }

    /**
     * testing method "getCatByWeight" with valid parameter -> expecting a not null return
     */
    @Test
    public void testGetCatByWeightCorrectPara() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("TestA", 2));
        assertNotNull(cafe.getCatByWeight(1, 3));
    }

    /**
     * testing method "getCatByWeight" with valid parameter -> expecting a null return (no result found)
     */
    @Test
    public void testGetCatByWeightCorrectParaNoResult() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("TestA", 5));
        assertNull(cafe.getCatByWeight(1, 3));
    }

    /**
     * testing method "getCatCount" for return value -> expecting a not null return
     */
    @Test
    public void testGetCatCount() {
        CatCafe cafe = new CatCafe();
        assertNotNull(cafe.getCatCount());
    }

    /**
     * testing method "getCatCount" for correct return type -> expecting a long
     */
    @Test
    public void testGetCatCountReturnType() {
        CatCafe cafe = new CatCafe();
        try {
            long i = cafe.getCatCount();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * testing method "addCat" for exceptions
     */
    @Test
    public void testAddCat() {
        CatCafe cafe = new CatCafe();
        try {
            cafe.addCat(new FelineOverLord("TestA", 5));
            cafe.addCat(new FelineOverLord("TestB", 4));
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * testing method "addCat" for exceptions
     */
    @Test
    public void testGetCatByNameReturnType() {
        CatCafe cafe = new CatCafe();
        try {
            cafe.addCat(new FelineOverLord("TestA", 5));
            FelineOverLord testSubject1 = cafe.getCatByName("TestA");
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * testing method "addCat" for exceptions
     */
    @Test
    public void testGetCatByWeightReturnType() {
        CatCafe cafe = new CatCafe();
        try {
            cafe.addCat(new FelineOverLord("TestA", 5));
            FelineOverLord testSubject = cafe.getCatByWeight(3, 6);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }


}
