<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Danh sách sân bóng</title>
</head>
<body>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">Danh sách sân bóng</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12 ">
                    <div class="widget-box ui-sortable-handle">
                        <div class="widget-header">
                            <h5 class="widget-title">Tìm kiếm</h5>
                            <div class="widget-toolbar">
                                <a href="#" data-action="collapse">
                                    <i class="ace-icon fa fa-chevron-up"></i>
                                </a>

                            </div>
                        </div>

                        <div class="widget-body" style="font-family: 'Times New Roman', Times, serif">
                            <div class="widget-main">
                                <form action="/admin/pitchs-list" method="GET" class="border p-4 rounded bg-white shadow-sm">
                                    <div class="mb-3">
                                        <label class="form-label">Ngày bắt đầu:</label>
                                        <input type="date" name="startDate" class="form-control" required
                                               value="${param.startDate}">
                                    </div>
                                    <div class="mb-3">
                                        <label class="form-label">Ngày kết thúc:</label>
                                        <input type="date" name="endDate" class="form-control" required
                                               value="${param.endDate}">
                                    </div>
                                    <div class="mb-4">
                                        <label class="form-label">Loại sân:</label>
                                        <select name="pitchTypeId" class="form-select" required>
                                            <option value="">-- Chọn loại sân --</option>
                                            <option value="Sân 5 người" ${param.pitchTypeId == 'Sân 5 người' ? 'selected' : ''}>Sân 5 người</option>
                                            <option value="Sân 7 người" ${param.pitchTypeId == 'Sân 7 người' ? 'selected' : ''}>Sân 7 người</option>
                                            <option value="Sân 11 người" ${param.pitchTypeId == 'Sân 11 người' ? 'selected' : ''}>Sân 11 người</option>
                                        </select>
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-primary">Tìm sân trống</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                        <div class="pull-right">
                            <a href="/admin/building-edit">
                              <button class="btn btn-info" title="Thêm mới sân bóng">
                                  <i class="fa-solid fa-plus-circle"></i>
                              </button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- bảng danh sách -->

            <div class="row">
                <div class="col-xs-12">
                    <table id="tableList" class="table table-striped table-bordered table-hover"
                           style="margin: 3em 0 1.5em; font-family:'Times New Roman', Times, serif ;">
                        <thead>
                        <tr>
                            <th class="center">
                                <label class="pos-rel">
                                    <input type="checkbox" class="ace">

                                </label>
                            </th>
                            <th>Tên sân</th>
                            <th>Giá thuê(VNĐ)</th>
                            <th>Mô tả sân</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="item" items="${pitchList}">
                            <tr>
                                <td class="center">
                                    <label class="pos-rel">
                                        <input type="checkbox" class="ace" name="checkList" value="${item.id}">
                                        <span class="lbl"></span>
                                    </label>
                                </td>
                                <td>
                                        ${item.pitchName}
                                </td>
                                <td>
                                        ${item.price}
                                </td>
                                <td>
                                        ${item.description}
                                </td>
                                <td>
                                    <div class="hidden-sm hidden-xs btn-group">

                                        <button class="btn btn-xs btn-success" title="Giao sân bóng cho khách hàng"
                                                onclick="openCustomerModal(${item.id})">
                                            <i class="fa-solid fa-paper-plane"></i>
                                        </button>

                                        <a class="btn btn-xs btn-info" title="Sửa sân bóng"
                                           href="/admin/building-edit-${item.id}">
                                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                                        </a>

                                        <button class="btn btn-xs btn-danger " title="Xóa sân bóng"
                                                onclick="deleteBuilding(${item.id})">
                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                </div><!-- /.span -->
            </div>
        </div><!-- /.page-content -->
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="customerModal" tabindex="-1" aria-hidden="true"
     style="font-family: 'Times New Roman', Times, serif;">
    <div class="modal-dialog modal-dialog-centered modal-lg">
        <div class="modal-content p-4">
            <div class="modal-header">
                <h5 class="modal-title">Tìm kiếm khách hàng</h5>
            </div>

            <div class="modal-body">
                <div class="mb-3">
                    <label for="customerName" class="form-label">Tên khách hàng</label>
                    <input type="text" id="customerName" class="form-control" placeholder="Nhập tên khách hàng..."/>
                </div>
                <div class="text-center">
                    <button onclick="searchCustomer()" class="btn btn-primary px-4 mx-auto">Tìm khách hàng</button>
                </div>

                <div id="searchResults" class="mt-4">
                    <!-- Kết quả tìm kiếm sẽ hiển thị tại đây -->
                </div>
            </div>

            <div class="modal-footer">
                <button onclick="closeCustomerModal()" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
            </div>

        </div>
    </div>
</div>

<!-- Form chọn khoảng thời gian -->
<!-- Modal Nhập Thời Gian -->
<div class="modal fade" id="timeModal" tabindex="-1" aria-labelledby="timeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content" style="font-family: 'Times New Roman', Times, serif;">
            <div class="modal-header">
                <h5 class="modal-title" id="timeModalLabel">Nhập thời gian đặt sân</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
            </div>
            <div class="modal-body text-center">
                <div class="mb-3">
                    <label class="form-label">Ngày bắt đầu:</label>
                    <input type="date" id="startDate" class="form-control" />
                </div>
                <div class="mb-3">
                    <label class="form-label">Ngày kết thúc:</label>
                    <input type="date" id="endDate" class="form-control" />
                </div>
                <button onclick="generateBookingReceipt()" class="btn btn-success w-100">Xác nhận thời gian</button>
            </div>
        </div>
    </div>
</div>


<!-- PHIẾU ĐẶT SÂN -->
<div id="bookingReceiptModal" class="modal fade" tabindex="-1">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header bg-success text-white">
                <h5 class="modal-title">📄 Phiếu Đặt Sân</h5>
            </div>
            <div class="modal-body">
                <h6>👤 Thông tin Khách hàng</h6>
                <p>Họ tên: <span id="tenKH"></span></p>
                <p>Số điện thoại: <span id="customerPhone"></span></p>

                <h6>🏟️ Thông tin Sân</h6>
                <p>Tên sân: <span id="pitchName"></span></p>
                <p>Loại sân: <span id="pitchType"></span></p>

                <h6>🕒 Thời gian Đặt</h6>
                <p>Ngày bắt đầu: <span id="ngayBD"></span></p>
                <p>Ngày kết thúc: <span id="ngayKT"></span></p>
                <p>Tổng số buổi: <span id="totalDay"></span> buổi</p>

                <h6>💰 Chi phí</h6>
                <p>Giá thuê ước tính: <span id="totalPrice"></span> VNĐ</p>
                <p>Số tiền đặt cọc (10%): <span id="deposit"></span> VNĐ</p>
            </div>

            <div class="modal-footer">
                <button class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button class="btn btn-success" id="printReceiptBtn">✅ Xác nhận và In Phiếu</button>
            </div>
        </div>
    </div>
</div>

<script>
    let selectedCustomerID = null; //idKH
    let selectedPitchID = null; //idSan
    $('#btnPitch').click(function (e) {
        e.preventDefault();
        $('#listForm').submit();
    });

    function openCustomerModal(pitchID) {
        selectedPitchID = pitchID;
        $('#customerModal').modal();
    }

    function searchCustomer() {
        const name = $('#customerName').val();
        if (name === "") {
            document.getElementById("searchResults").innerHTML = "<p style='color:orange;'>Vui lòng nhập tên khách hàng cần tìm.</p>";
            return;
        }
        $.ajax({
            type: "GET",
            url: "/tim-khach-hang",
            data: {name: name},
            dataType: "json",
            success: function (data) {
                let html = `
         <h3 style="text-align:center; margin-bottom: 20px; color: #2c3e50;">Kết quả tìm kiếm</h3>
        <div style="display:flex; justify-content:center;">
            <table border="1" cellpadding="10" cellspacing="0" style="width:80%; text-align:center; border-collapse: collapse; font-family: Arial, sans-serif;">
                <thead style="background-color: #007bff; color: white;">
                    <tr>
                        <th>Mã KH</th>
                        <th>Họ tên</th>
                        <th>SĐT</th>
                        <th>Email</th>
                        <th>lựa chọn</th>
                    </tr>
                </thead>
                <tbody>
                `;
                if (data.length === 0) {
                    html += `<tr><td colspan="5">Không tìm thấy khách hàng nào.</td></tr>`;
                } else {
                    $.each(data, function (index, c) {
                        html += '<tr>';
                        html += '<td class="text-center">' + c.id + '</td>';
                        html += '<td class="text-center">' + c.fullname + '</td>';
                        html += '<td class="text-center">' + c.phone + '</td>';
                        html += '<td class="text-center">' + c.email + '</td>';
                        html += '<td class="text-center">';
                        html += '<button class="btn btn-primary btn-sm" onclick="selectCustomer(' + c.id + ', \'' + selectedPitchID + '\')">Chọn</button>';
                        html += '</td>';
                        html += '</tr>';

                    });
                }
                html += `</tbody></table></div>`;
                $('#searchResults').html(html);
            },
            error: function () {
                $('#searchResults').html("<p style='color:red; text-align:center;'>Đã xảy ra lỗi khi tìm kiếm.</p>");
            }
        });
    }

    function selectCustomer(idKH, idSan) {
        selectedCustomerID = idKH;
        $('#customerModal').modal('hide');
        $('#timeModal').modal('show');
    }


    function generateBookingReceipt() {
        const startDate = document.getElementById('startDate').value;
        const endDate = document.getElementById('endDate').value;
        if (!startDate || !endDate) {
            alert("Vui lòng nhập đầy đủ ngày bắt đầu và ngày kết thúc!");
            return;
        }
        const data = {
            customerId: selectedCustomerID,
            pitchId: selectedPitchID,
            startDate: startDate,
            endDate: endDate
        };

        $.ajax({
            url: '/create',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log(response)
                console.log(response[0].tenKH)
                console.log(response[0].ngayBD)
                console.log(response[0].ngayKT)
                $('#timeModal').modal('hide');
                showBookingSummary(response[0]);
            },
            error: function(xhr) {
                alert("Lỗi khi tạo phiếu đặt sân: " + xhr.responseText);
            }
        });
    }

    function showBookingSummary(data) {
        $('#tenKH').text(data.tenKH || 'Không có');
        $('#customerPhone').text(data.customerPhone || 'Không có');
        $('#pitchName').text(data.pitchName || 'Không có');
        $('#pitchType').text(data.pitchType || 'Không có');
        $('#ngayBD').text(data.ngayBD || '');
        $('#ngayKT').text(data.ngayKT || '');
        $('#totalDay').text(data.totalDay || 0);
        $('#totalPrice').text((data.totalPrice || 0).toLocaleString('vi-VN'));
        $('#deposit').text((data.deposit || 0).toLocaleString('vi-VN'));
        $('#bookingReceiptModal').modal('show');
    }
    function closeBookingSummary() {
        document.getElementById("booking-summary").style.display = "none";
    }

</script>

</body>
</html>
