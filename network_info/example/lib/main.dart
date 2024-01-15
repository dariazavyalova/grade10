import 'package:flutter/material.dart';
import 'package:network_info/network_info.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _networkType = "unknown";
  final _networkInfoPlugin = NetworkInfo();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_networkType\n'),
        ),
        floatingActionButton: FloatingActionButton(onPressed: () => _getNetworkType()),
      ),
    );
  }

  void _getNetworkType() async {
    _networkType = await _networkInfoPlugin.getNetworkType() ?? 'unknown';
    setState(() {});
  }
}
