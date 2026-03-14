# 🏟️ Hệ thống quản lý cho thuê sân bóng mini

Hệ thống **Quản lý cho thuê sân bóng mini** hỗ trợ **chủ sân** và **nhân viên** quản lý toàn bộ nghiệp vụ: đặt sân theo **buổi/tháng**, lập **phiếu đặt sân**, **hóa đơn thanh toán**, quản lý  **khách hàng – sân bóng – user**, quản lý **mặt hàng ăn uống & nhập hàng**, và **thống kê doanh thu**.

---

## 🌐 Demo
- Live Demo: `http://13.229.183.145:8080/`

---

## ✨ Tính năng nổi bật

### ✅ Nghiệp vụ chính
- Đặt sân **theo buổi / theo tháng**, quản lý **khung giờ** và **trạng thái sân**.
- Lập **phiếu đặt sân**, **hóa đơn**, quản lý **hợp đồng**.
- Quản lý **khách hàng**, **user hệ thống**, phân quyền **ADMIN / NHÂN VIÊN**.
- Quản lý **mặt hàng ăn uống**, **nhập hàng** từ nhà cung cấp.
- Thống kê doanh thu theo **tháng / quý / năm**.

### ⭐ Điểm mạnh khi trình bày dự án
- Bám sát **nghiệp vụ thực tế** của sân bóng mini.
- Thiết kế CSDL rõ ràng, **chuẩn hóa dữ liệu**.
- Kiến trúc **MVC / Layered Architecture** tách lớp rõ ràng.
- Bảo mật & phân quyền với **Spring Security**.
- Dễ mở rộng: REST API, frontend riêng, tích hợp thanh toán online.

---

## 🧰 Công nghệ sử dụng

### Backend
- **Java 8**
- **Spring Boot 2.0.9**
- **Spring Data JPA + Hibernate**
- **Spring Security**
- **JSP + JSTL** (View)

### Database
- **MySQL**
- File database có sẵn: `database/football_mini_db.sql`

### Hạ tầng & DevOps (đã triển khai)
- Docker hoá ứng dụng Spring Boot (WAR chạy trên Tomcat 9)
- CI/CD tự động: **build image → push Docker Hub → deploy AWS EC2 qua SSH**
- Production chạy trên **AWS EC2**
- Database production sử dụng **Aiven MySQL** (tách rời app, không deploy kèm)

---

## 🏗️ Kiến trúc hệ thống

Mô hình **MVC / Layered Architecture**:

- Controller
- Service
- Repository
- Entity
- DTO

Package chính:
- `com.javaweb.controller.*`
- `com.javaweb.service.*`
- `com.javaweb.repository.*`
- `com.javaweb.entity.*`
- `com.javaweb.model.dto.*`

---

## 🔐 Tài khoản đăng nhập mẫu

| Role       | Username    | Password |
|------------|-------------|----------|
| ADMIN      | nguyenvana  | 123456   |
| NHÂN VIÊN  | nguyenvand  | 123456   |

---

## 🧩 Mô tả nghiệp vụ tổng thể

### 1) Quản lý sân bóng
- Một sân bóng có thể gồm **nhiều sân mini**.
- Có thể ghép **2 hoặc 4 sân mini** thành sân lớn theo yêu cầu.
- Mỗi sân có: **loại sân, giá thuê, trạng thái** (trống / đã đặt theo khung giờ).

### 2) Quản lý khách hàng
- Thêm / sửa / xóa khách hàng.
- Tìm kiếm khách hàng theo tên.
- Một khách hàng có thể có **nhiều phiếu đặt sân**.

---

## 🎯 Module ĐẶT SÂN (Core Feature)

### Luồng nghiệp vụ
1. Khách hàng yêu cầu đặt sân.
2. Nhân viên chọn chức năng **Đặt sân**.
3. Hệ thống hiển thị giao diện tìm sân trống theo khung giờ.
4. Nhân viên nhập khung giờ, chọn loại sân → **Tìm kiếm**.
5. Hệ thống truy vấn CSDL và hiển thị danh sách sân còn trống.
6. Nhân viên chọn sân phù hợp.
7. Hệ thống hiển thị giao diện **chọn khách hàng**.
8. Nhân viên nhập tên KH → tìm kiếm → chọn KH (hoặc tạo KH mới).
9. Nhập ngày bắt đầu / ngày kết thúc.
10. Xác nhận → hệ thống sinh **Phiếu đặt sân** gồm:
   - Thông tin khách hàng
   - Thông tin sân
   - Giá thuê 1 buổi
   - Khung giờ thuê trong tuần
   - Tổng số buổi
   - Tổng tiền dự kiến
   - Tiền đặt cọc
11. Lưu dữ liệu vào CSDL.

---

## 💳 Module KHÁCH HÀNG THANH TOÁN

### Luồng nghiệp vụ
1. KH yêu cầu thanh toán.
2. NV chọn menu **Tìm phiếu đặt sân**.
3. NV nhập tên KH → tìm kiếm.
4. Hệ thống hiển thị danh sách KH trùng tên → NV chọn đúng KH.
5. Hệ thống hiển thị danh sách phiếu đặt sân → NV chọn phiếu cần thanh toán.
6. Hệ thống hiển thị **HÓA ĐƠN**:
   - Thông tin khách hàng
   - Thông tin thuê sân
   - Các buổi thuê
7. Nếu có khiếu nại: NV chỉnh sửa số lượng / mặt hàng → hệ thống cập nhật tổng tiền.
8. NV xác nhận thanh toán → hệ thống lưu hóa đơn & cập nhật CSDL.

---

## 📊 Module THỐNG KÊ DOANH THU

### Luồng nghiệp vụ
1. Quản lý chọn menu **Thống kê doanh thu**.
2. Chọn thống kê theo: **tháng / quý / năm**.
3. Hệ thống hiển thị doanh thu **12 tháng gần nhất** (mới → cũ).
4. Chọn 1 dòng để xem chi tiết hóa đơn theo khoảng thời gian.

---

## 🗂️ Cấu trúc thư mục quan trọng

- `src/main/java/com/javaweb` — Backend (Controller/Service/Repository/Entity/DTO)
- `src/main/webapp/WEB-INF/views` — JSP views
- `src/main/resources` — config & static assets
- `database/football_mini_db.sql` — database mẫu
- `.github/workflows/ci-cd.yml` — pipeline CI/CD lên AWS EC2
- `Dockerfile` — dockerize ứng dụng

---

## 🚀 Hướng dẫn chạy project (Local)

### 1) Yêu cầu
- Java 8
- Maven
- MySQL

### 2) Import database
1. Tạo DB: `football_mini_db`
2. Import file: `database/football_mini_db.sql`

### 3) Cấu hình database
File: `src/main/resources/application-dev.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/football_mini_db
spring.datasource.username=root
spring.datasource.password=12345
