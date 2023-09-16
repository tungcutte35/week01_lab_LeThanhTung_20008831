<?php
/* Smarty version 3.1.30, created on 2023-05-11 15:21:08
  from "C:\Users\Admin\Desktop\xampp\htdocs\shophoa\admin\views\v_hoa_don.tpl" */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.30',
  'unifunc' => 'content_645cebc43e3039_14989496',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '40eeaf9f97b1b687edc0767baee3cb35d965e693' => 
    array (
      0 => 'C:\\Users\\Admin\\Desktop\\xampp\\htdocs\\shophoa\\admin\\views\\v_hoa_don.tpl',
      1 => 1683726267,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_645cebc43e3039_14989496 (Smarty_Internal_Template $_smarty_tpl) {
if (!is_callable('smarty_modifier_date_format')) require_once 'C:\\Users\\Admin\\Desktop\\xampp\\htdocs\\shophoa\\admin\\smarty\\libs\\plugins\\modifier.date_format.php';
?>
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Danh sách hóa đơn</div>
        <div class="card-body">
          <div class="table-responsive">
            <table class="table" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Mã đơn hàng</th>
                  <th>Khách hàng</th>
                  <th>Ngày đặt</th>
                  <th>Tổng tiền</th>
                  <th>Trạng thái</th>
                  <th>Hành động</th>
                </tr>
              </thead>
              <tbody>
                <?php
$_from = $_smarty_tpl->smarty->ext->_foreach->init($_smarty_tpl, $_smarty_tpl->tpl_vars['doc_hoa_don']->value, 'hoa_don');
if ($_from !== null) {
foreach ($_from as $_smarty_tpl->tpl_vars['hoa_don']->value) {
?>
                <tr id="delete<?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->ma_hoa_don;?>
">
                  <td>
                     <a href="chi_tiet_hoa_don.php?ma_hoa_don=<?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->ma_hoa_don;?>
" title="Xem chi tiết đơn hàng"target="_blank">
                       <?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->ma_hoa_don;?>

                     </a>
                   </td>
                  <td><?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->ten_khach_hang;?>
</td>
                  <td><?php echo smarty_modifier_date_format($_smarty_tpl->tpl_vars['hoa_don']->value->ngay_dat,'%d-%m-%Y');?>
</td>
                  <td><?php echo number_format($_smarty_tpl->tpl_vars['hoa_don']->value->tong_thanh_tien);?>
 đ</td>
                  <td><?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->trang_thai;?>
</td>
                  <td>
                  <?php if (($_smarty_tpl->tpl_vars['hoa_don']->value->trang_thai) == 'Chưa xử lý') {?>
                      <button type="button" onclick="updateAjax(<?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->ma_hoa_don;?>
)" class="btn btn-success">Xử lý</button>
                  <?php }?>
                      <button type="button" onclick="deleteAjax(<?php echo $_smarty_tpl->tpl_vars['hoa_don']->value->ma_hoa_don;?>
)" class="btn btn-danger">Xóa</button>
                  </td>
                </tr>
                <?php
}
}
$_smarty_tpl->smarty->ext->_foreach->restore($_smarty_tpl);
?>


              </tbody>
            </table>
          </div>
        </div>
        <?php echo '<script'; ?>
 src="public/js/ajax/ajax_update_hoa_don.js"><?php echo '</script'; ?>
>
        <?php echo '<script'; ?>
 src="public/js/ajax/ajax_delete_hoa_don.js"><?php echo '</script'; ?>
><?php }
}
