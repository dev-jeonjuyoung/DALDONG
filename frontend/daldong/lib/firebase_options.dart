// File generated by FlutterFire CLI.
// ignore_for_file: lines_longer_than_80_chars, avoid_classes_with_only_static_members
import 'package:firebase_core/firebase_core.dart' show FirebaseOptions;
import 'package:flutter/foundation.dart'
    show defaultTargetPlatform, kIsWeb, TargetPlatform;

/// Default [FirebaseOptions] for use with your Firebase apps.
///
/// Example:
/// ```dart
/// import 'firebase_options.dart';
/// // ...
/// await Firebase.initializeApp(
///   options: DefaultFirebaseOptions.currentPlatform,
/// );
/// ```
class DefaultFirebaseOptions {
  static FirebaseOptions get currentPlatform {
    if (kIsWeb) {
      return web;
    }
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return android;
      case TargetPlatform.iOS:
        return ios;
      case TargetPlatform.macOS:
        return macos;
      case TargetPlatform.windows:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for windows - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      case TargetPlatform.linux:
        throw UnsupportedError(
          'DefaultFirebaseOptions have not been configured for linux - '
          'you can reconfigure this by running the FlutterFire CLI again.',
        );
      default:
        throw UnsupportedError(
          'DefaultFirebaseOptions are not supported for this platform.',
        );
    }
  }

  static const FirebaseOptions web = FirebaseOptions(
    apiKey: 'AIzaSyB8G3eU72uDRVzUdzMmgi0Sihrso39OxtU',
    appId: '1:825520873267:web:260a1144bfdf8f4ac92846',
    messagingSenderId: '825520873267',
    projectId: 'daldong',
    authDomain: 'daldong.firebaseapp.com',
    storageBucket: 'daldong.appspot.com',
  );

  static const FirebaseOptions android = FirebaseOptions(
    apiKey: 'AIzaSyDFFlHTYquqQ4Q_O9bbhOeBCVrzFbJBJHs',
    appId: '1:825520873267:android:7320be52b93fbac9c92846',
    messagingSenderId: '825520873267',
    projectId: 'daldong',
    storageBucket: 'daldong.appspot.com',
  );

  static const FirebaseOptions ios = FirebaseOptions(
    apiKey: 'AIzaSyAymSBIOz_URGm0MFNP3EErRZuSldoWdH8',
    appId: '1:825520873267:ios:37e88652c3b11913c92846',
    messagingSenderId: '825520873267',
    projectId: 'daldong',
    storageBucket: 'daldong.appspot.com',
    iosClientId: '825520873267-6b0bll5og120p4sav2tsjr7fdmadsl7f.apps.googleusercontent.com',
    iosBundleId: 'com.ssafy.daldong',
  );

  static const FirebaseOptions macos = FirebaseOptions(
    apiKey: 'AIzaSyAymSBIOz_URGm0MFNP3EErRZuSldoWdH8',
    appId: '1:825520873267:ios:d9ed1c0ad42390c3c92846',
    messagingSenderId: '825520873267',
    projectId: 'daldong',
    storageBucket: 'daldong.appspot.com',
    iosClientId: '825520873267-cppab71d5fmhafqa47rf8ve3aieo9egv.apps.googleusercontent.com',
    iosBundleId: 'com.ssafy.daldong.RunnerTests',
  );
}