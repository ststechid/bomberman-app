package id.ststech.javabasic.bombermanapp.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import id.ststech.javabasic.bombermanapp.BomberManUtil;

public class BomberManUtilTest {

	@Test
	public void testValidateCommand() {
		
		Assertions.assertTrue(BomberManUtil.validateCommand("bomb john +"));
		Assertions.assertTrue(BomberManUtil.validateCommand("bomb john -"));
		Assertions.assertTrue(BomberManUtil.validateCommand("bomb john reset"));
		Assertions.assertTrue(BomberManUtil.validateCommand("fire john +"));
		Assertions.assertTrue(BomberManUtil.validateCommand("fire john -"));
		Assertions.assertTrue(BomberManUtil.validateCommand("fire john reset"));
		Assertions.assertTrue(BomberManUtil.validateCommand("boot john +"));
		Assertions.assertTrue(BomberManUtil.validateCommand("boot john -"));
		Assertions.assertTrue(BomberManUtil.validateCommand("boot john reset"));
		Assertions.assertTrue(BomberManUtil.validateCommand("kick john +"));
		Assertions.assertTrue(BomberManUtil.validateCommand("kick john -"));
		Assertions.assertTrue(BomberManUtil.validateCommand("throw john +"));
		Assertions.assertTrue(BomberManUtil.validateCommand("throw john -"));
		Assertions.assertTrue(BomberManUtil.validateCommand("poison john +"));
		Assertions.assertTrue(BomberManUtil.validateCommand("poison john -"));
		
		Assertions.assertTrue(!BomberManUtil.validateCommand("kick john reset"));
		Assertions.assertTrue(!BomberManUtil.validateCommand("throw john reset"));
		Assertions.assertTrue(!BomberManUtil.validateCommand("poison john reset"));
	}
}
