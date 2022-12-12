package cn.cs.springframework.core.io;

import cn.cs.springframework.uitil.ClassUtils;
import cn.hutool.core.lang.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author cs
 * @Date 2022-11-25 17:00
 */
public class ClassPathResource implements Resource{
    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
