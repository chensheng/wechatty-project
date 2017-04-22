package space.chensheng.wechatty.common.conf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface PropOption {
	boolean isPath() default false;
	
	boolean notNull() default false;
	
	boolean ignore() default false;
}
