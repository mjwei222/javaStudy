package com.qunar.study.xiaosxian.java8.nio;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class MappedChannelRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (FileChannel fchan = (FileChannel) Files.newByteChannel(Paths.get("D:\\work\\201711\\2017-11.txt"));) {
			long fsize = fchan.size();
			MappedByteBuffer mBuf = fchan.map(FileChannel.MapMode.READ_ONLY, 0, fsize);
			for (int i = 0; i < fsize; i++)
				System.out.print((char)mBuf.get());
			System.out.println();
		} catch (InvalidPathException e) {
			System.out.println("Path Error " + e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
