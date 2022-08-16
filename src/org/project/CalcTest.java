package org.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcTest {

	@Test
	void testAdd() {
		Calc calc = new Calc();
		assertEquals(10, calc.add(5, 5));
	}

	@Test
	void testSub() {
		Calc calc = new Calc();
		assertEquals(10, calc.sub(15, 5));
	}

	@Test
	void testMulti() {
		Calc calc = new Calc();
		assertEquals(10, calc.multi(2, 5));
	}

	@Test
	void testDiv() {
		Calc calc = new Calc();
		assertEquals(10, calc.div(50, 5));
	}

}
