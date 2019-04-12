package io.deoki.blog.util.attribute;

public class PermissionType {
    public enum Post implements PermissionEnumType {
        POST_WRITE, POST_UPDATE, POST_DELETE;

        @Override
        public String getName(String enumName) {
            return PermissionType.Post.valueOf(enumName).name();
        }
    }
    public enum User implements PermissionEnumType {
        USER_WRITE, USER_UPDATE, USER_DELETE;

        @Override
        public String getName(String enumName) {
            return PermissionType.User.valueOf(enumName).name();
        }
    }
    public enum Category implements PermissionEnumType {
        CATEGORY_WRITE, CATEGORY_UPDATE, CATEGORY_DELETE;

        @Override
        public String getName(String enumName) {
            return PermissionType.Category.valueOf(enumName).name();
        }
    }
}
