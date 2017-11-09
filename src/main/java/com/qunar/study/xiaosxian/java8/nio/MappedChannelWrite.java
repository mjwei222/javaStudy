package com.qunar.study.xiaosxian.java8.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (FileChannel fchan = (FileChannel) Files.newByteChannel(Paths.get("D:\\work\\201711\\abcd.txt"), StandardOpenOption.WRITE,
				StandardOpenOption.READ,StandardOpenOption.CREATE)){
			MappedByteBuffer mBuf = fchan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
			for (int i = 0; i < 26; i++)
				mBuf.put((byte)('A' + i));
		} catch(InvalidPathException e) {
			System.out.println("Path Error " + e);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
