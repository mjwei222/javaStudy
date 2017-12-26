package com.qunar.study.xiaosxian.java8.nio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try ( BufferedOutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("D:\\work\\201711\\abcd.txt")))) {
			for (int i = 0; i < 26; i++)
				fout.write((byte) ('A' + i));
		} catch(InvalidPathException e) {
			System.out.println("Path Error " + e);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
