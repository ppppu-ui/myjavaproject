enum UserRole {
    ADMIN("管理员", new String[]{"用户管理", "内容审核", "系统设置", "数据导出"}),
    USER("普通用户", new String[]{"浏览内容", "发布评论", "个人信息修改"}),
    GUEST("访客", new String[]{"浏览内容"});
    private final String roleName;
    private final String[] permissions;

    UserRole(String roleName, String[] permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public void printPermissions() {
        System.out.println("===== " + roleName + "权限 =====");
        for (String permission : permissions) {
            System.out.println("- " + permission);
        }
    }

    public String getRoleName() {
        return roleName;
    }
}

public class test18 {
    public static void main(String[] args) {
        for (UserRole role : UserRole.values()) {
            role.printPermissions();
            System.out.println();
        }

        UserRole currentRole = UserRole.USER;
        System.out.println("当前用户角色：" + currentRole.getRoleName());
        currentRole.printPermissions();
    }
}
