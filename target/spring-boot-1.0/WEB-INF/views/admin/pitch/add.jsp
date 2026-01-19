<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Thêm sân bóng</title>
</head>

<body style="font-family: 'Times New Roman', Times, serif">

<div class="container mt-4">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card border-success">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0">➕ Thêm sân bóng</h5>
                </div>

                <div class="card-body">
                    <form action="/admin/pitch-save" method="post">

                        <div class="form-group">
                            <label>Tên sân</label>
                            <input type="text" name="pitchName"
                                   class="form-control"
                                   placeholder="Nhập tên sân..."
                                   required>
                        </div>

                        <div class="form-group">
                            <label>Loại sân</label>
                            <select name="type" class="form-control" required>
                                <option value="">-- Chọn loại sân --</option>
                                <c:forEach var="t" items="${pitchTypes}">
                                    <option value="${t}">${t}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Giá thuê (VNĐ)</label>
                            <input type="number" name="price"
                                   class="form-control"
                                   min="0" required>
                        </div>

                        <div class="form-group">
                            <label>Mô tả</label>
                            <textarea name="description"
                                      class="form-control"
                                      rows="3"></textarea>
                        </div>

                        <div class="text-center mt-4">
                            <button class="btn btn-success px-4">💾 Lưu mới</button>
                            <a href="/admin/pitchs-list" class="btn btn-secondary px-4 ml-2">❌ Hủy</a>
                        </div>

                    </form>
                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>
