<?php
/* Smarty version 3.1.30, created on 2023-05-16 09:27:39
  from "C:\Domains\tiemhoaanna.com\httpdocs\smarty\templates\layouts\body.tpl" */

/* @var Smarty_Internal_Template $_smarty_tpl */
if ($_smarty_tpl->_decodeProperties($_smarty_tpl, array (
  'version' => '3.1.30',
  'unifunc' => 'content_64634c8b2a4172_24046610',
  'has_nocache_code' => false,
  'file_dependency' => 
  array (
    '5a3c58dc4e7ff84b7a8cf63046c3d1022d5ad06d' => 
    array (
      0 => 'C:\\Domains\\tiemhoaanna.com\\httpdocs\\smarty\\templates\\layouts\\body.tpl',
      1 => 1684229225,
      2 => 'file',
    ),
  ),
  'includes' => 
  array (
  ),
),false)) {
function content_64634c8b2a4172_24046610 (Smarty_Internal_Template $_smarty_tpl) {
?>
            <?php if (isset($_smarty_tpl->tpl_vars['view']->value)) {?>
                <?php $_smarty_tpl->_subTemplateRender(((string)$_smarty_tpl->tpl_vars['view']->value), $_smarty_tpl->cache_id, $_smarty_tpl->compile_id, 0, $_smarty_tpl->cache_lifetime, array(), 0, true);
?>

            <?php }?>
        <div id="link">
         <div class="link-media">
         <a href="<?php echo $_smarty_tpl->tpl_vars['fb']->value;?>
" class="fa fa-facebook"></a>
         </div>
         <div class="link-media1">
         <a href="tel:<?php echo $_smarty_tpl->tpl_vars['phone_number']->value;?>
" class="fa fa-phone"></a>
         </div>
         <div class="link-media2">
         <a href="https://zalo.me/<?php echo $_smarty_tpl->tpl_vars['phone_number']->value;?>
">
         <img src="./public/images/zalo.png" alt="">
         </a>
         </div>
        </div>
        </div>

<?php }
}
