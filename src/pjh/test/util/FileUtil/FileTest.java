package pjh.test.util.FileUtil;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import pjh.cmn.consts.CmnConsts;
import pjh.cmn.util.FileUtil;

class FileTest {
	final String txtFilePath = CmnConsts.SHARE_ROOT_PATH.concat(CmnConsts.FILE_DIV.TXT).concat(File.separator);
	final String fileName = "myName";
	final String writeStr = "PJH";

	@Test
	void writeFileTest() {
		String filePath = FileUtil.getFileDivPath(txtFilePath.concat(fileName));
		FileUtil.writeStrToFile(writeStr, filePath);
		
		assertTrue(FileUtil.isPathExists(filePath));
	}
	
	@Test
	void readFileTest() {
		writeFileTest();
		
		String filePath = FileUtil.getFileDivPath(txtFilePath.concat(fileName), CmnConsts.FILE_DIV.TXT);
		
		assertEquals(FileUtil.readFileToStr(filePath), writeStr);
	}
	
	@Test
	void getNullFileDivPathTest() {
		assertEquals(FileUtil.getFileDivPath(null), "");
	}
	
	@Test
	void getNullFileDivPathParamTest() {
		assertEquals(FileUtil.getFileDivPath(null, CmnConsts.FILE_DIV.TXT), "");
	}
	
	@Test
	void renameFileTest() {
		writeFileTest();
		
		String oldStr = fileName;
		String newStr = "newFile";
		String oldPath = FileUtil.getFileDivPath(txtFilePath.concat(oldStr));
		String newPath = FileUtil.renameFilePath(oldPath, oldStr, newStr);
		
		// Dir도 테스트 가능
		assertTrue(FileUtil.isPathExists(newPath));		
	}
}