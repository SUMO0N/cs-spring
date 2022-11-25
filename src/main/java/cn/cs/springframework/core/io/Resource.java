package cn.cs.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author cs
 * @Date 2022-11-25 16:59
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
