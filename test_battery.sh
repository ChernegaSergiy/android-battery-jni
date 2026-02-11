#!/data/data/com.termux/files/usr/bin/bash
php -r '
$socket = @fsockopen("unix:///data/data/com.chernegasergiy.battery/files/socket", -1, $errno, $errstr, 5);
if (!$socket) {
    echo "Error: $errstr ($errno)\n";
    exit(1);
}
$port = rand(10000, 60000);
$tcp = @stream_socket_server("tcp://127.0.0.1:$port", $errno, $errstr);
if (!$tcp) {
    echo "Error: $errstr ($errno)\n";
    fclose($socket);
    exit(1);
}
fwrite($socket, "PORT:$port\n");
$client = @stream_socket_accept($tcp, 5);
if ($client) {
    $response = fread($client, 4096);
    echo $response . "\n";
    fclose($client);
}
fclose($tcp);
fclose($socket);
'
