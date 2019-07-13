package io.mine.ft.train;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 单元测试样例
 */
@RunWith(JUnit4.class)
public abstract class BaseTest {

	public final static Long tenantId = 0L;

	static {
		// TenantIdThreadLocal.setTenantId(tenantId);
	}
}
