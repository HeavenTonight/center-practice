package cn.yong.center.practice.utils;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: WenLong Li
 * @Date: 2020/05/13 10:35
 * @Description: 压缩工具类
 */
public class CompressedFileUtil {
    private CompressedFileUtil() {
    }

    /**
     * 压缩文件
     *
     * @param files   文件
     * @param zipFile 目标文件
     * @throws IOException 压缩异常
     */
    public static void compressedFile(List<String> files, String zipFile) throws IOException {
        File targetFile = new File(zipFile);
        try (FileOutputStream outputStream = new FileOutputStream(targetFile);
             ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(outputStream))) {
            createCompressedFileByFileName(out, files);
        }
    }

    /**
     * 压缩文件
     *
     * @param files      文件
     * @param targetFile 目标文件
     * @throws IOException 压缩异常
     */
    public static void compressedFile(List<File> files, File targetFile) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(targetFile);
             ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(outputStream))) {
            createCompressedFile(out, files);
        }
    }

    /**
     * 压缩指定列表的文件
     *
     * @param out   zip out put stream
     * @param files files
     * @throws IOException exception
     */
    private static void createCompressedFileByFileName(ZipOutputStream out, List<String> files) throws IOException {
        for (String file : files) {
            createCompressedFile(out, new File(file));
        }
    }

    /**
     * 压缩指定列表的文件
     *
     * @param out   zip out put stream
     * @param files files
     * @throws IOException exception
     */
    private static void createCompressedFile(ZipOutputStream out, List<File> files) throws IOException {
        for (File f : files) {
            createCompressedFile(out, f);
        }
    }

    /**
     * 压缩指定列表的文件
     *
     * @param out  zip out put stream
     * @param file file
     * @throws IOException exception
     */
    private static void createCompressedFile(ZipOutputStream out, File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            out.putNextEntry(new ZipEntry(file.getName()));
            int j;
            byte[] buffer = new byte[1024];
            while ((j = fis.read(buffer)) > 0) {
                out.write(buffer, 0, j);
            }
        }
    }
}
