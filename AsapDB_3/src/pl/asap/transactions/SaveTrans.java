package pl.asap.transactions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SaveTrans extends TransBlank {
	
	
	
	public SaveTrans (Object bean, String fieldName, String value)	{
		super(bean);
		Method method = null;
		String methodName = "set"+fieldName;
		try {
			method = bean.getClass().getMethod(methodName, String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			method.invoke(bean, value);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block

		}
			
		exeTransaction();
		
		
	}

}
