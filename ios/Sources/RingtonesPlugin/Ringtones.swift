import Foundation

@objc public class Ringtones: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
