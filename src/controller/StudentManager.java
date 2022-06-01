package controller;

import comparator.SortByDown;
import comparator.SortByUp;
import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("===== Menu ====");
        System.out.println("1. Xem danh sách sinh viên");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng");

        int choice1 = Integer.parseInt(scanner.nextLine());
        switch (choice1) {
            case 1:
                show();
                break;
            case 2:
                addStudent();
                break;
            case 3:
                System.out.println("Nhập Mã sinh viên: ");
                String code1 = scanner.nextLine();
                updateList(code1);
                break;
            case 4:
                System.out.println("Nhập Mã số sinh viên muốn xóa: ");
                String code2 = scanner.nextLine();
                deleteStudent(code2);
                break;
            case 5:
                sortByAverage();
                break;
            case 6:
                readFile();
                break;
            case 7:
                writeFile();
                break;
            case 8:
                System.exit(0);
        }

    }

    public void show() {
        for (Student st : students) {
            System.out.println(st);
        }
    }

    public void addStudent() {
        try {
            System.out.println("Mời bạn nhập thông tin: ");
            System.out.println("Nhập Họ tên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập Mã sinh viên: ");
            String code = scanner.nextLine();
            System.out.println("Nhập tuổi: ");
            int age = Integer.parseInt(scanner.nextLine());


            String gender;
            while (true){
                try {
                    System.out.println("Nhập giới tính");
                    gender = scanner.nextLine();
                    if (gender.equals("Nam") || gender.equals("Nữ"))
                        break;
                    else
                        throw new Exception();

                }catch (Exception e) {
                    System.err.println("Nhập sai, mời nhập lại! ");
                }

            }
            System.out.println("Nhập địa chỉ: ");
            String address = scanner.nextLine();
            System.out.println("Nhập điểm trung bình: ");
            int averageSubject = Integer.parseInt(scanner.nextLine());

            Student student = new Student(code, name, age, gender, address, averageSubject);
            students.add(student);
        } catch (Exception e) {
            System.out.println("Nhập sai, mời nhập lại!");
        }
    }



    public void updateList(String code) {
        Student editList = null;
        for (Student st : students) {
            if (st.getCode().equals(code))
                editList = st;
        }
        if (editList != null) {
            try {
                int index = students.indexOf(editList);
                System.out.println("Nhập Mã sinh viên mới: ");
                editList.setCode(scanner.nextLine());
                System.out.println("Nhập Họ tên mới: ");
                editList.setName(scanner.nextLine());
                System.out.println("Nhập tuổi mới: ");
                editList.setAge(Integer.parseInt(scanner.nextLine()));
                System.out.println("Nhập giới tính mới: ");
                editList.setGender(scanner.nextLine());
                System.out.println("Nhập địa chỉ mới: ");
                editList.setAddress(scanner.nextLine());
                System.out.println("Nhập điểm trung bình mới: ");
                editList.setAverageSubject(Integer.parseInt(scanner.nextLine()));
                students.set(index, editList);
                System.out.println("Sửa dữ liệu thành công!");
            } catch (Exception e) {
                System.out.println("Nhập sai, mời nhập lại!");
            }

        } else {
            System.out.println("Không tìm thấy Mã sinh viên trong danh sách!");
        }
    }

    public void deleteStudent(String code) {
        Student deleteStudent = null;
        for (Student st : students) {
            if (st.getCode().equals(code))
                deleteStudent = st;
        }
        if (deleteStudent != null) {
            System.out.println("Nhập xác nhận");
            System.out.println("Y: Xóa");
            System.out.println("Ký tự khác：Thoát ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                students.remove(deleteStudent);
                System.out.println("Xóa thành công! ");
            }
        } else
            System.out.println("Không tìm thấy Mã sinh viên trong danh sách! ");

    }

    public void sortByAverage() {
        System.out.println("Sắp xếp điểm trung bình theo thứ tự: ");
        System.out.println("1. Sắp xếp theo thứ tự giảm dần: ");
        System.out.println("2. Sắp xếp theo thứ tự giảm dần: ");
        System.out.println("3. Thoát");
        System.out.println("Chọn chức năng: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        switch (choice2) {
            case 1:
                students.sort(new SortByDown());
                show();
                break;
            case 2:
                students.sort(new SortByUp());
                show();
                break;
            case 3:
                System.exit(0);
        }
    }


    public void readFile() {

        try {
            File file = new File("data/students.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] arr = line.split(",");
                String code = arr[0];
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                int averageSubject = Integer.parseInt(arr[5]);
                students.add(new Student(code, name, age, gender, address, averageSubject));
                line = bufferedReader.readLine();

            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Lỗi!");
        }

    }

    public void writeFile() {
        File file = new File("studentList.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student x : students) {
                bufferedWriter.write(x.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Lỗi");
        }
    }

}
