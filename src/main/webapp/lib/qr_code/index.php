<?php
include("qrlib.php");
$qr_code = isset($_GET['qrcode']) ? $_GET['qrcode'] : "";
$qr_code = strip_tags($qr_code);
$qr_code = base64_decode($qr_code);
QRcode::png($qr_code);
?>