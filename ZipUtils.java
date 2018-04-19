import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 
 * @author lepus
 * @date 2018-4-19 下午6:52:33
 */
public class ZipUtils {
	
	public static void main(String[] args) {
		unzip("C:\\Users\\WANG\\Desktop\\aa\\a.zip");
	}

	public static void unzip(String pathname) {
		File file = new File(pathname);
		if (file.exists()) {
			try {
				ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
				String parent = file.getParent();
				ZipEntry entry = null;
				while((entry = zis.getNextEntry()) != null){
					if(!entry.isDirectory()){
						File fout = new File(parent, entry.getName());
						if(!fout.exists())
							fout.getParentFile().mkdirs();
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fout));
						int len = -1;
						byte[] buff = new byte[1024];
						while((len = zis.read(buff)) != -1){
							bos.write(buff, 0, len);
						}
						bos.close();
					}
				}
				zis.close();
				System.out.println("unzip success : " + file.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("file not found");
		}
	}

}
