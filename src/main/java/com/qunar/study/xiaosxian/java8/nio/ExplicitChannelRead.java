package com.qunar.study.xiaosxian.java8.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class ExplicitChannelRead {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count;
		try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("D:\\work\\201711\\2017-11.txt"))) {
			ByteBuffer mBuf = ByteBuffer.allocate(128);
			do {
				count = fChan.read(mBuf);
				if (count != -1) {
					mBuf.rewind();
					for (int i = 0; i < count; i++) {
						System.out.println((char)mBuf.get());
						
					}
				}
			} while (count != -1);
			System.out.println();
		} catch (InvalidPathException e ) {
			System.out.println("Path error " + e);
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
