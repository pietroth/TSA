# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/notification.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/notification.cppm"
module;

export module communication.notification;

import std;

import communication.base_protocol;
import communication.mbt;

export namespace communication {
    using namespace communication;

#pragma pack(push, 1)
    struct Notification {
        BaseProtocol protocol;
        MBT mbt;

        Notification(std::uint16_t size, std::uint16_t type)
            : protocol(size), mbt(type) {}
    };
#pragma pack(pop)

    class NotificationRegistry {
    private:
        std::unordered_set<std::uint16_t> ids;

    public:
        void registerId(std::uint16_t id) {
            ids.insert(id);
        }

        void registerIds(std::unordered_set<std::uint16_t>&& newIds) {
            ids.merge(newIds);
        }

        bool exist(std::uint16_t id) const noexcept {
            return ids.contains(id);
        }
    };
}
