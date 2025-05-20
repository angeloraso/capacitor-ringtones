// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "AnuradevCapacitorRingtones",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "AnuradevCapacitorRingtones",
            targets: ["RingtonesPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "RingtonesPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/RingtonesPlugin"),
        .testTarget(
            name: "RingtonesPluginTests",
            dependencies: ["RingtonesPlugin"],
            path: "ios/Tests/RingtonesPluginTests")
    ]
)