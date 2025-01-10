@echo off
echo Cleaning old compiled files...
rmdir /S /Q bin 2>NUL
mkdir bin

echo Compiling source files...

javac -d bin ^
    src\main\controller\MedicalManagement.java ^
    src\main\controller\MedicalManagementController.java ^
    src\main\managers\AppointmentManager.java ^
    src\main\managers\MedicalRecordManager.java ^
    src\main\managers\PatientManager.java ^
    src\main\models\Appointment.java ^
    src\main\models\Consultation.java ^
    src\main\models\MedicalRecord.java ^
    src\main\models\Patient.java ^
    src\main\gui\GuiGui.java

if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)

echo Compilation successful.
pause
