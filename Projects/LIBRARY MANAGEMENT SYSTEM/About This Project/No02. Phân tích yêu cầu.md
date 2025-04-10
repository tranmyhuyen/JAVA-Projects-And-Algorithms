## 🌟 MỤC TIÊU CỦA DỰ ÁN

Xây dựng một **chương trình quản lý thư viện chạy trên console** (tức là dùng dòng lệnh), có khả năng:

✅ Quản lý người dùng với các vai trò khác nhau (Admin, Thủ thư, Người đọc)  
✅ Quản lý sách (thêm, xoá, mượn, trả)  
✅ Lưu trữ dữ liệu vào file để lần sau mở lại vẫn còn (gọi là "file persistence")  
✅ Áp dụng OOP – chia lớp hợp lý, có tính kế thừa, đóng gói, đa hình

---

## 🎯 TỔNG QUAN CÁC THÀNH PHẦN CẦN CÓ

| Thành phần | Vai trò |
|------------|--------|
| **Người dùng (User)** | Có 3 loại: `Admin`, `Librarian`, `Reader` – mỗi loại có quyền khác nhau |
| **Sách (Book)** | Có 2 loại: `PrintedBook` (sách in, được mượn) và `Ebook` (không được mượn) |
| **Hành động** | Tuỳ người dùng mà được làm: thêm user, thêm sách, mượn sách, v.v. |
| **Lưu trữ dữ liệu** | Tất cả dữ liệu được lưu trong 3 file: `users.txt`, `books.txt`, `transactions.txt` |
| **Giao diện console** | Người dùng nhập username + password để đăng nhập và thao tác qua menu hiển thị trong dòng lệnh |

---

## 🧩 DANH SÁCH CHỨC NĂNG CỤ THỂ

### 🔐 1. Đăng nhập (mọi người dùng đều phải qua bước này)
- Nhập username + password
- Phân quyền: xác định bạn là Admin, Librarian, hay Reader
- Nếu sai thông tin thì thông báo đăng nhập thất bại

---

### 🧑‍💼 2. Chức năng của **Admin**
> **Quyền cao nhất, chỉ quản lý người dùng**

- Thêm người dùng mới (chọn loại: Admin / Librarian / Reader)
- Xoá người dùng theo username
- Xem danh sách người dùng

---

### 📚 3. Chức năng của **Librarian**
> **Quản lý sách**

- Thêm sách mới (PrintedBook hoặc Ebook)
- Xoá sách theo ISBN
- Xem danh sách tất cả các sách

---

### 📖 4. Chức năng của **Reader**
> **Tương tác với sách**

- Mượn sách (chỉ được mượn PrintedBook đang còn)
- Trả sách đã mượn
- Xem danh sách tất cả các sách

---

## 🏗️ CÁCH TỔ CHỨC CODE (CHIA FILE, CHIA NHÓM LỚP)

Để chương trình gọn, dễ hiểu, chia thành 3 phần chính:

---

### 📦 **1. model/** — Lưu các lớp dữ liệu (object)

| File | Mô tả |
|------|------|
| `User.java` | Lớp trừu tượng cha cho Admin, Librarian, Reader |
| `Admin.java`, `Librarian.java`, `Reader.java` | Kế thừa từ `User`, có menu riêng |
| `Book.java` | Lớp cha trừu tượng cho sách |
| `PrintedBook.java` | Sách có thể mượn, có số trang |
| `Ebook.java` | Sách không mượn được, có định dạng file |

---

### ⚙️ **2. service/** — Xử lý logic chính

| File | Mô tả |
|------|------|
| `AuthService.java` | Xác thực người dùng từ `users.txt` |
| `UserService.java` | Thêm / xoá / hiển thị người dùng (Admin dùng) |
| `BookService.java` | Thêm / xoá / hiển thị sách (Librarian dùng) |
| `TransactionService.java` | Xử lý mượn / trả sách (Reader dùng) |

---

### 🧾 **3. util/** — Hỗ trợ xử lý file

| File | Mô tả |
|------|------|
| `FileManager.java` | Đọc / ghi từ các file `.txt`, lưu dữ liệu vĩnh viễn |

---

### 🖥️ **4. LibrarySystem.java** (main file)
- Là entry point – nơi chạy chương trình
- Gọi các service phù hợp tuỳ theo role đăng nhập
- Hiển thị menu và nhận lựa chọn từ người dùng

---

## 📁 CÁCH LƯU FILE DỮ LIỆU

1. **users.txt**
   ```
   admin1,1234,Admin
   lib01,abcd,Librarian
   reader88,xyz,Reader
   ```

2. **books.txt**
   ```
   Printed,Harry Potter,J.K.Rowling,Fantasy,9781234,true,null,400
   Ebook,Java Basics,John Doe,Education,9785678,false,null,pdf
   ```

3. **transactions.txt**
   ```
   reader88,9781234,borrowed,2025-04-01
   ```

---

## 🚧 CÁCH XÂY DỰNG THEO TỪNG BƯỚC

| Bước | Việc cần làm | Gợi ý |
|------|--------------|-------|
| 1 | Tạo `User` và các class con | Dùng `abstract class` |
| 2 | Tạo `Book` và các class con | Phân biệt PrintedBook và Ebook |
| 3 | Viết `FileManager` để đọc / ghi file | Đọc mỗi dòng, split dữ liệu |
| 4 | Viết `AuthService` để login | So sánh username + password |
| 5 | Viết `LibrarySystem.java` | Vòng lặp `while(true)` cho menu |
| 6 | Viết chức năng `add/remove/list` cho Admin | Đơn giản, thao tác mảng List |
| 7 | Viết chức năng `add/remove/list` sách cho Librarian | Nhập sách rồi lưu file |
| 8 | Viết `borrow/return` cho Reader | Update trạng thái và ghi transaction |
| 9 | Tạo test case và demo chương trình | Dùng Scanner test thực tế |
| 10 | Viết báo cáo PDF và đẩy code lên GitHub | Nhớ ghi rõ hướng dẫn chạy |

---

## 📝 GỢI Ý LỘ TRÌNH CODE

```text
Tuần 1:
✅ Hoàn thành model/: User, Book và class con  
✅ Viết AuthService và FileManager cơ bản

Tuần 2:
✅ Xây giao diện console và menu chính  
✅ Viết chức năng Admin và Librarian

Tuần 3:
✅ Xử lý mượn/trả sách và lưu transaction  
✅ Tối ưu code, fix lỗi, thêm valid dữ liệu

Tuần 4:
✅ Viết báo cáo PDF  
✅ Đẩy code GitHub, hoàn thiện nộp bài
```
