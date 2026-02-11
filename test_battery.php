<?php
$socket = socket_create(AF_UNIX, SOCK_STREAM, 0);
socket_bind($socket, "com.chernegasergiy.battery");
socket_listen($socket, 1);

$client = socket_accept($socket);
$port = socket_read($client, 4096);

if ($port !== false && strpos($port, 'PORT:') === 0) {
    $port = (int) substr($port, 5);

    $client2 = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
    socket_connect($client2, "127.0.0.1", $port);

    $response = socket_read($client2, 4096);
    echo $response . PHP_EOL;

    socket_close($client2);
}

socket_close($client);
socket_close($socket);
