import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class HelloXlassLoader extends  ClassLoader{
    private static byte[] lastByte;
    public static void main(String[] args) throws  Exception{
        File helloFile  =new File("D:\\javademo\\src\\Hello.xlass");
        FileInputStream is = new FileInputStream(helloFile);
        try {
            byte[] helloBytes = new byte[(int)helloFile.length()];
            is.read(helloBytes);
            for (int i = 0; i < helloBytes.length; i++) {
                lastByte[i] = (byte)(255-helloBytes[i]) ;
            }
            Object instance = new HelloXlassLoader().findClass("Hello").newInstance();
            Method method = instance.getClass().getMethod("hello");
            method.invoke(instance);
        }catch (IOException e ) {
            e.printStackTrace();
        }finally {
            if(null !=is){
                try{
                    is.close();
                }catch (IOException e ){
                    e.printStackTrace();
                }
            }
        }

    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return  defineClass(name,lastByte,0,lastByte.length);
    }
}
